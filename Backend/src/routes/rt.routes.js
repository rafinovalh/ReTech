const passport = require('passport');
const express = require('express');
const router = express.Router();
const itController = require('../controllers/rt.controllers');


router.post('/loginseller', itController.loginseller);

router.post('/loginbuyer', itController.loginbuyer);

router.post('/registerbuyer', itController.registerbuyer);

router.post('/registerseller', itController.registerseller);

router.get('/showuser', itController.showUser);

router.get('/showPhoneSeller', itController.showPhoneSeller);

router.delete('/deletebuyer', itController.deletebuyer);

router.delete('/deleteseller', itController.deleteseller);

router.put('/changePasswordseller', itController.changePasswordseller);

router.put('/changePasswordbuyer', itController.changePasswordbuyer);

router.post('/addProduct', itController.addProduct);

router.delete('/deleteProduct', itController.deleteProduct);

router.get('/showProduct', itController.showProduct);

router.get('/showProductSeller', itController.showProductSeller);

router.put('/updateProduct', itController.updateProduct);

router.post('/addBid', itController.addBid);

router.get('/showBidBuyer', itController.showBidBuyer);

router.get('/showBidSeller', itController.showBidSeller);

router.put('/updateBidseller', itController.updateBidseller);

router.post('/addTransaction', itController.addTransaction);

router.get('/showTransactionbuyer', itController.showTransactionbuyer);

router.get('/showTransactionseller', itController.showTransactionseller);

function authenticateUser(req, res, next) {
    // Check if the user is authenticated by checking if the session contains a user object
    if (req.session.user) {
      next();
    } else {
      res.status(401).json({ message: 'Unauthorized' });
    }
  }

module.exports = router;