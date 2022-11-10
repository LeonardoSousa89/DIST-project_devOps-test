const axios=require('axios')

/**instalar sempre a versão 2.6.7 */
const fetch=require('node-fetch')

const express=require('express')
const server=express.Router()

const postUrl='http://localhost:8765/Usert/dist/worker/administration'


server.route(`/dist/worker/:id/administration/`).get(async(req, res)=>{

    let userId={id: req.params.id}
    let id=Number(userId.id)

    const getUrl=`http://localhost:8765/User/dist/worker/${id}/administration/`

 await fetch(getUrl,{method: 'GET'})
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

}).get(async(req, res)=>{
    
        const getUrl=`http://localhost:8765/User/dist/worker/${id}/administration?size=${size}&page=${page}`
})

module.exports=server