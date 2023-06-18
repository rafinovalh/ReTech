const {Client} = require('pg');

//initialize database connection
const db = new Client({
    host: 'ep-cold-mode-215887.ap-southeast-1.aws.neon.tech',
    database: 'ReTech',
    user: 'rafinoval72',
    password: 'HcvUqeRQx98M',
    port: 5432,
    sslmode: 'require',
    ssl: true
});

//Melakukan koneksi dan menunjukkan indikasi database terhubung
db.connect((err) => {
    if (err) {
        console.log(err);
        }
        else {
            console.log('Connected to the database');
        }
});

module.exports = db;