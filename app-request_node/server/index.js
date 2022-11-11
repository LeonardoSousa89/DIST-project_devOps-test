const axios=require('axios')

/**instalar sempre a versão 2.6.7 */
const fetch=require('node-fetch')

const express=require('express')
const server=express.Router()

server.route(`/dist/worker/:id/administration`).get(async(req, res)=>{
    let userId={id: req.params.id}
    let id=Number(userId.id)

    let pageRequest={
        size: req.query.size,
        page: req.query.page
    }

    const URL=`http://localhost:8765/User/dist/worker/${id}/administration?page=${pageRequest.page}`

    await fetch(URL,{method: 'GET'})
    .then(response=>{
        
        if(response.status === 200){
            res.status(200)
            return response.json()
        }
        
        if(response.status === 404) {
            res.status(404)
            msg="Resource not found"
            JSON.stringify(msg)
            return msg
        }
        
        if(response.status === 504 || 
            response.status === 503 || 
            response.status === 500 ) {
            res.status(500)
            msg="There's an error with server" 
            JSON.stringify(msg)
            return msg
         }
        }).then(response=> res.json(response))
})





server.route(`/dist/worker/administration`).post(async(req,res)=>{

    let data={ workerName:"Lana Lang", 
               workerEmail:"lanacoofe@gmail.com", 
               workerPost:"seller",
               workerAddress:"Smallville",
               workerPhoneNumber:"(415) 555-7548",
               workerAge:"24",
               admin:{"userId":2}
            }
        

    const URL='http://localhost:8765/User/dist/worker/administration'

    await fetch(  URL,
                { method: 'POST', 
                  body: JSON.stringify(data),
                  headers:{
                    'Content-type':'application/json'
                }
            })
    .then(response=>{
        
        if(response.status === 201){
            res.status(200)
            msg="Worker created"
            JSON.stringify(msg)
            return msg
        }
        
        if(response.status === 400) {
            res.status(400)
            msg="Was an error, verify if some field is empty or perhaps already exists"
            JSON.stringify(msg)
            return msg
        }
        
        if(response.status === 504 || 
            response.status === 503 || 
            response.status === 500 ) {
            res.status(500)
            msg="There's an error with server" 
            JSON.stringify(msg)
            return msg
         }
        }).then(response=> res.json(response))

})




module.exports=server