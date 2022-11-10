const port=8766

const log=require('morgan')
const server=require('./server')

const express=require('express')
const app=express()

app.use(log('dev'))
app.use('/',server)
app.use(express.json())
app.use(express.urlencoded({extended: true}))


app.listen(port, ()=>{
    console.log(`SERVER PORT: ${port}`)
})