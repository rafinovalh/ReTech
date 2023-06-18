//import packages
const express = require('express');
const bodyParser = require('body-parser');
const session = require('express-session');

//initialize the app as express app
const app = express();

const port = process.env.PORT || 3000;
const cors = require('cors');
const passport = require('passport');
const local = require('./src/middlewares/local');
const rtRoute = require('./src/routes/rt.routes');
const store = new session.MemoryStore();

const corsOptions = {
    origin: '*',
    Credentials: true,
    optionsSuccessStatus: 200
};

app.use(session({
    secret: 'secret',
    resave: false,
    cookie: {maxAge: 6000000},
    saveUninitialized: false,
    store
    }));

app.use(passport.initialize());
app.use(passport.session());

app.use(cors(corsOptions));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.get('/', (req, res) => {
    if(req.user){
        res.send(req.user);and
    }else{
        res.send('Not logged in');
    }
    //res.json({ message: 'Welcome to the mm backend' }); 
});

app.use('/rt', rtRoute);

app.listen(port, () => {
    console.log('Server is running on port: ' + port);
});