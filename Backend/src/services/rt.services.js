const res = require('express/lib/response');
const { use } = require('passport/lib');
const db = require('../configs/db.config');
const helper = require('../utils/helpers');


//USERS
//loginseller
async function loginseller (rt){
    const {username, password} = rt;
    const query = `SELECT * FROM seller WHERE username = '${username}'`;
    const result = await db.query(query);
    if(result.rows.length === 0){
        return {
            message: 'User not found'
        }
    }else{
        const user = result.rows[0];
        const comparePass = await helper.comparePassword(password, user.password);
        if(comparePass){
            return {
                message: 'Login successful',
                user
            }
        }else{
            return {
                message: 'Password is not correct'
            }
        }
    }
}

//loginbuyer
async function loginbuyer (rt){
    const {username, password} = rt;
    const query = `SELECT * FROM buyer WHERE username = '${username}'`;
    const result = await db.query(query);
    if(result.rows.length === 0){
        return {
            message: 'User not found'
        }
    }else{
        const user = result.rows[0];
        const comparePass = await helper.comparePassword(password, user.password);
        if(comparePass){
            return {
                message: 'Login successful',
                user
            }
        }else{
            return {
                message: 'Password is not correct'
            }
        }
    }
}

//registerbuyer
async function registerbuyer (rt){
    const {username, email, password, phone} = rt;
    const pass = await helper.hashPassword(password);
    const query = `INSERT INTO buyer (username, password, email, phone) VALUES ('${username}', '${pass}', '${email}', '${phone}')`;
    const result = await db.query(query);
    if(result.rowCount === 1){
        return {
            message: 'User Created'
        }
    }else{
        throw new Error('Error creating user');

    }
}

//registerseller
async function registerseller (rt){
    const {username, email, password, phone} = rt;
    const pass = await helper.hashPassword(password);
    const query = `INSERT INTO seller (username, password, email, phone) VALUES ('${username}', '${pass}', '${email}', '${phone}')`;
    const result = await db.query(query);
    if(result.rowCount === 1){
        return {
            message: 'User Created'
        }
    }else{
        throw new Error('Error creating user');

    }
}

//showUser
async function showUser (user){
    if(user){
        const query = `SELECT * FROM buyer WHERE username = '${user.username}' UNION SELECT * FROM seller WHERE username = '${user.username}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'User found',
                user : result.rows
            }
        }else{
            return {
                message: 'User not found'
            }
        }
    }else{
        return {
            message: 'User not found'
        }
    }
}

//showPhoneSeller
async function showPhoneSeller (user){
    if(user){
        const query = `SELECT username, phone FROM seller WHERE username = '${user.username}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'User found',
                user : result.rows
            }
        }else{
            return {
                message: 'User not found'
            }
        }
    }else{
        return {
            message: 'User not found'
        }
    }
}

//deletebuyer
async function deletebuyer (user){
    if(user){
        const query = `DELETE FROM buyer WHERE id = '${user.id}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'User deleted'
            }
        }
        else{
            return {
                message: 'User not found'
            }
        }
    }
    else{
        return {
            message: 'USer not logged in'
        }
    }
}

//deleteseller
async function deleteseller (user){
    if(user){
        const query = `DELETE FROM seller WHERE id = '${user.id}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'User deleted'
            }
        }
        else{
            return {
                message: 'User not found'
            }
        }
    }
    else{
        return {
            message: 'USer not logged in'
        }
    }
}


//changePasswordbuyer
async function changePasswordbuyer (user){
    if(user){
        const pass = await helper.hashPassword(user.password);
        const query = `UPDATE buyer SET password = '${pass}' WHERE id = '${user.id}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'Success Changed Password',
            }
        }else{
            return {
                message: 'Failed Changed Password'
            }
        }
    }else{
        return {
            message: 'Failed Changed Password'
        }
    }
}


//changePasswordseller
async function changePasswordseller (user){
    if(user){
        const pass = await helper.hashPassword(user.password);
        const query = `UPDATE seller SET password = '${pass}' WHERE id = '${user.id}'`;
        const result = await db.query(query);
        if(result.rowCount === 1){
            return {
                message: 'Success Changed Password',
            }
        }else{
            return {
                message: 'Failed Changed Password'
            }
        }
    }else{
        return {
            message: 'Failed Changed Password'
        }
    }
}




//PRODUCTS
//addProduct
async function addProduct (rt){
    const {seller_id, name, description, price, is_negotiable, status} = rt;
    const query = `INSERT INTO products (seller_id, name, description, price, is_negotiable, status_products) VALUES ('${seller_id}','${name}', '${description}', '${price}', '${is_negotiable}', '${status}')`;
    const result = await db.query(query);
    if(result.rowCount === 1){
        return {
            message: 'Product Created'
        }
    }else{
        return{
            message: 'Error'
        } 
    }
}

//deleteProduct
async function deleteProduct(rt){
    const {Id} = rt;
    const query = `DELETE FROM products WHERE id=${Id}`;
    const result = await db.query(query);
    if(result.rowCount > 0){
        return {
            message: 'Item deleted'
        }
    }
    else{
        return {
            message: 'Item not found'
        }
    }
}

//showProduct
async function showProduct (){
    const query = `SELECT products.id, seller.id as seller_id, seller.username, products.name, products.description, products.price, products.is_negotiable, products.status_products FROM products INNER JOIN seller ON products.seller_id = seller.id`;
    const result = await db.query(query);
    if(result.rowCount){
        return {
            message: 'Product found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No product found'
        }
    }
}

//showProduct
async function showProductSeller (rt){
    const {seller_id} = rt;
    const query = `SELECT * FROM products WHERE seller_id = '${seller_id}'`;
    const result = await db.query(query);
    if(result.rowCount){
        return {
            message: 'Product found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No product found'
        }
    }
}

//updateProduct
async function updateProduct(rt){
    const {id, seller_id, name, description, price, is_negotiable, status} = rt;
    const query = `UPDATE products SET name='${name}', description='${description}', price='${price}', is_negotiable='${is_negotiable}', status_products='${status}' WHERE id=${id} AND seller_id='${seller_id}'`;
    const result = await db.query(query);
    if(result.rowCount > 0){
        return {
            message: 'Product Updated'
        }
    }else{
        return{
            message: 'No product Updated'
        } 
    }  
}




//BIDS
//addBids
async function addBid (rt){
    const {product_id, seller_id, price_offered, status_bids} = rt;
    const query = `INSERT INTO bids (product_id, buyer_id, price_offered, status_bids) VALUES ('${product_id}', '${seller_id}', '${price_offered}', '${status_bids}')`;
    const result = await db.query(query);
    if(result.rowCount === 1){
        return {
            message: 'Bids added'
        }
    }else{
        return{
            message: 'Error'
        } 
    }
}

//showBidBuyer
async function showBidBuyer (rt){
    const {buyer_id} = rt;
    const query = `SELECT bids.id, bids.product_id, bids.buyer_id, products.name, bids.price_offered, products.price as sell_price, products.description, bids.status_bids FROM bids INNER JOIN products ON products.id = bids.product_id WHERE bids.buyer_id = '${buyer_id}'`;
    const result = await db.query(query);
    if(result.rowCount){
        return {
            message: 'Bids found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No bids found'
        }
    }
}

//showBidSeller
async function showBidSeller (rt){
    const {product_id} = rt;
    const query = `SELECT bids.id, bids.product_id, bids.buyer_id, products.name, bids.price_offered, products.price as sell_price, products.description, bids.status_bids FROM bids INNER JOIN products ON products.id = bids.product_id WHERE bids.product_id = '${product_id}'`;
    const result = await db.query(query);
    if(result.rowCount){
        return {
            message: 'Bids found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No bids found'
        }
    }
}

//updateBidseller
async function updateBidseller(rt){
    const {id, status_bids} = rt;
    const query = `UPDATE bids SET status_bids='${status_bids}' WHERE id=${id}`;
    const result = await db.query(query);
    if(result.rowCount > 0){
        return {
            message: 'Bids Updated'
        }
    }else{
        return{
            message: 'No bids Updated'
        } 
    }  
}



//TRANSACTIONS
//addTransaction
async function addTransaction (rt){
    const {product_id, seller_id, buyer_id, price_deal} = rt;
    const query = `INSERT INTO transactions (product_id, seller_id, buyer_id, price_deal) VALUES ('${product_id}', '${seller_id}', '${buyer_id}', '${price_deal}')`;
    const result = await db.query(query);
    if(result.rowCount === 1){
        return {
            message: 'Transactions added'
        }
    }else{
        return{
            message: 'Error'
        } 
    }
}

//showTransactionbuyer
async function showTransactionbuyer (rt){
    const {buyer_id} = rt;
    const query = `SELECT product_id, seller_id, price_deal FROM transactions WHERE buyer_id = '${buyer_id}'`;
    const result = await db.query(query);
    if(result.rowCount){
        return {
            message: 'Transaction found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No Transaction found'
        }
    }
}

//showTransactionseller
async function showTransactionseller (rt){
    const {seller_id} = rt;
    const query = `SELECT product_id, buyer_id, price_deal FROM transactions WHERE seller_id=${seller_id}`;
    const result = await db.query(query);
    if(result.rowCount > 0){
        return {
            message: 'Transaction found',
            showProduct : result.rows
        }
    }else{
        return {
            message: 'No Transaction found'
        }
    }
}

module.exports = {
    loginseller,
    loginbuyer,
    registerbuyer,
    registerseller,
    showUser,
    showPhoneSeller,
    deletebuyer,
    deleteseller,
    changePasswordbuyer,
    changePasswordseller,
    addProduct,
    deleteProduct, 
    showProduct,
    showProductSeller,
    updateProduct,
    addBid,
    showBidBuyer,
    showBidSeller,
    updateBidseller,
    addTransaction,
    showTransactionbuyer,
    showTransactionseller
}
