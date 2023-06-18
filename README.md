# ReTech
A Money Manager App based on Android using NodeJS and PostgreSQL.

---
## Gambaran Umum Aplikasi Program
Aplikasi yang digunakan untuk melakukan jual beli barang bekas elektronik dengan adanya sistem bid harga didalamnya yang mana berbasis Android serta menggunakan  ```Java``` pada FrontEnd dan ```NodeJS``` pada BackEnd yang juga menggunakan ```PostgreSQL``` sebagai Databasenya yang dibantu dengan layanan ```Neon Console``` sebagai layanan Cloudnya

---
## OOP Project For Selection Assistent Program

Project ini dibuat oleh saya sendiri sebagai mahasiswa Teknik Komputen Universitas Indonesia:

1. [Rafi' Noval Hady](https://github.com/rafinovalh) 

---
## Explanation Table in Program
### 1.  ```buyer```

Table buyer adalah table yang berguna untuk menyimpan data ```buyer``` dari appnya. Tabel ini memiliki beberapa attributes, diantaranya adalah:
```
1. id
2. username
3. password
4. email
5. phone
```

### 2.  ```seller```

Table seller adalah table yang berguna untuk menyimpan data ```seller``` dari appnya. Tabel ini memiliki beberapa attributes, diantaranya adalah:
```
1. id
2. username
3. password
4. email
5. phone
```

### 3.  ```products```

Table products adalah table yang berguna untuk menyimpan data ```products``` dari appnya. Tabel ini memiliki beberapa attributes, diantaranya adalah:
```
1. id
2. seller_id
3. name
4. description
5. price
6. status_products
```

### 4.  ```bids```

Table bids adalah table yang berguna untuk menyimpan data ```bids``` dari appnya. Tabel ini memiliki beberapa attributes, diantaranya adalah:
```
1. id
2. product_id
3. buyer_id
4. price_offered
5. status_bids
```

### 5.  ```transactions```

Table transaction adalah table yang berguna untuk menyimpan data ```transactions``` dari appnya. Tabel ini memiliki beberapa attributes, diantaranya adalah:
```
1. id
2. product_id
3. buyer_id
4. seller_id
5. price_deal
```
---
## Postman Documentation Collection
[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/24275980/2s93si2Aij)
---
# Relation Table dan UML
```UML:```
![alt text!](https://github.com/rafinovalh/ReTech/blob/main/Assets/UML_ReTech.png)

```ERD:```

![alt text!](https://github.com/rafinovalh/ReTech/blob/main/Assets/ERD_ReTech.png)


---
# FlowChart

```FlowChart:```

![alt text!](https://github.com/rafinovalh/ReTech/blob/main/Assets/Flowchart_ReTech.png)

---
