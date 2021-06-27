import express from 'express'
import devBundle from './devBundle'
import template  from './../template'


const app = express()
devBundle.compile(app)

import path from 'path'

var pgp = require('pg-promise')(/* options */)
var db = pgp('postgres://postgres:postgres@localhost:5432/mydb')

// String dbURL = "jdbc:postgresql://localhost:5432/mydb";
// 			String username = "postgres";
// 			String password = "postgres";


// var pgp = require('pg-promise')(/* options */)
// var db = pgp('postgres://username:password@host:port/database')

// db.one('SELECT $1 AS value', 123)
//   .then(function (data) {
//     console.log('DATA:', data.value)
//   })
//   .catch(function (error) {
//     console.log('ERROR:', error)
//   })

db.one('INSERT INTO public.User(userid, email, firstname, lastname, grant_date) VALUES(${userid}, ${email}, ${firstname}, ${lastname}, ${grantdate}) RETURNING *'
, {
            userid: 12,
            email: "hd@mail",
            firstname: "Hammy",
            lastname: "Dong",
            grantdate : new Date(),
        }
        
        )
        
        .catch(function (error) {
    console.log('ERROR:', error)
  })



db.one('select * from public.User where userid=11')
  .then(function (data) {
    console.log('DATA:', data.email)
    console.log('DATA:', data.firstname)
    console.log('DATA:', data.lastname)
  })
  .catch(function (error) {
    console.log('ERROR:', error)
  })

  db.many('select * from public.User')
  .then(function (data) {
    console.log('DATA:', data)
  })
  .catch(function (error) {
    console.log('ERROR:', error)
  })

const CURRENT_WORKING_DIR = process.cwd()
app.use('/dist', express.static(path.join(CURRENT_WORKING_DIR, 'dist')))
app.get('/', (req, res )=>{res.status(200).send(template())
})

let port = process.env.PORT || 3000
app.listen(port, function onStart(err){
  if (err) {
    console.log(err)
  }
  console.info('Server started on port %s.', port)
})

app.get('/', (request, response) => {
  response.json({ info: 'Node.js, Express, and Postgres API' })
})

// String dbURL = "jdbc:postgresql://localhost:5432/mydb";
// 			String username = "postgres";
// 			String password = "postgres";

// const Pool = require('pg').Pool
// const pool = new Pool({
//   user: "postgres",
//   host: 'localhost',
//   database :'mydb',
//   password:"postgres",
//   port: 5432
// })

// const getUsers = (request, response)=>{
//   pool.query('select * from public.User', (error, results)=>{
//     if(error){
//       console.error(error)
//       throw error
//     }
//     console.log("no error")
//   //  console.log(json(results.row))
//     response.status(200).json(results.row)
//   })
// }


// app.get('/users', getUsers)



//const url = process.env.MONGODB_URI || 'mongodb://localhost:27017/mernSimpleSetup'
// MongoClient.connect(url ,(err, db) => {
//   console.log("Connected successfully to mongodb server")
//   db.close()
// })
