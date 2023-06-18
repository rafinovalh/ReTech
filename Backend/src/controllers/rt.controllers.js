const itService = require('../services/rt.services');

async function loginseller(req, res) {
    try {
      const result = await itService.loginseller(req.body);
      if (result.message === 'Login successful') {
        req.session.user = result.user;
        res.status(200).json(result);
      } else {
        res.status(401).json(result);
      }
    } catch (err) {
      res.status(500).json({ message: 'Internal server error' });
    }
}

async function loginbuyer(req, res) {
    try {
      const result = await itService.loginbuyer(req.body);
      if (result.message === 'Login successful') {
        req.session.user = result.user;
        res.status(200).json(result);
      } else {
        res.status(401).json(result);
      }
    } catch (err) {
      res.status(500).json({ message: 'Internal server error' });
    }
}

async function registerbuyer(req,res){
    try{
        const result = await itService.registerbuyer(req.body);
        res.json(result);
    }catch(err){
        res.json(err.detail);
    }
}

async function registerseller(req,res){
  try{
      const result = await itService.registerseller(req.body);
      res.json(result);
  }catch(err){
      res.json(err.detail);
  }
}

async function showUser(req,res){
    try{
        const result = await itService.showUser(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showPhoneSeller(req, res){
    try{
        const result = await itService.showPhoneSeller(req.body);
        res.json(result);
    }catch(err){
        res.json(err)
    }
}

async function deletebuyer(req,res){
    try{
        const result = await itService.deletebuyer(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function deleteseller(req,res){
  try{
      const result = await itService.deleteseller(req.body);
      res.json(result);
  }catch(err){
      res.json(err);
  }
}

async function changePasswordbuyer(req,res){
  try{
      const result = await itService.changePasswordbuyer(req.body);
      res.json(result);
  }catch(err){
      res.json(err);
  }
}

async function changePasswordseller(req,res){
  try{
      const result = await itService.changePasswordseller(req.body);
      res.json(result);
  }catch(err){
      res.json(err);
  }
}

async function addProduct(req,res){
  try{
      const result = await itService.addProduct(req.body);
      res.json(result);
  }catch(err){
      res.json(err);
  }
}

async function deleteProduct(req,res){
  try{
      const result = await itService.deleteProduct(req.body);
      res.json(result);
  }catch(err){
      res.json(err);
  }
}

async function showProduct(req,res){
    try{
        const result = await itService.showProduct(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showProductSeller(req,res){
    try{
        const result = await itService.showProductSeller(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function updateProduct(req,res){
    try{
        const result = await itService.updateProduct(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
  }


async function addBid(req,res){
    try{
        const result = await itService.addBid(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showBidBuyer(req,res){
    try{
        const result = await itService.showBidBuyer(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showBidSeller(req,res){
    try{
        const result = await itService.showBidSeller(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function updateBidseller(req,res){
    try{
        const result = await itService.updateBidseller(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function addTransaction(req,res){
    try{
        const result = await itService.addTransaction(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showTransactionbuyer(req,res){
    try{
        const result = await itService.showTransactionbuyer(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
    }
}

async function showTransactionseller(req,res){
    try{
        const result = await itService.showTransactionseller(req.body);
        res.json(result);
    }catch(err){
        res.json(err);
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