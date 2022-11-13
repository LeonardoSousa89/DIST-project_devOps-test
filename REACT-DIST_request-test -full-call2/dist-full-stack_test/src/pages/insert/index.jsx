import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Insert() {

    const [workerName,         setWorkerName]=useState([])
    const [workerEmail,        setWorkerEmail]=useState([])
    const [workerPost,         setWorkerPost]=useState([])
    const [workerAddress,      setWorkerAddress]=useState([])
    const [workerPhoneNumber,  setWorkerPhoneNumber]=useState([])
    const [workerAge,          setWorkerAge]=useState([])

    const navigate=useNavigate()

    useEffect(()=>{},[])

    function exit(){
        navigate("/", {replace: true})
    }

    function send(){

        let id=localStorage.getItem('ID')
        let userIdJson=JSON.parse(id)

        let URL='http://localhost:8765/User/dist/worker/administration'

        let data={  
            workerName,
            workerEmail,
            workerPost,
            workerAddress,
            workerPhoneNumber,
            workerAge,
            admin: {userId: userIdJson}
        }

        let config={ method: 'POST', 
            body: JSON.stringify(data),
            headers:{
                'Content-type':'application/json'
            }
        }

        fetch(URL, config).then(response=>{
            if(response.status === 201){
                response.json()
                alert('worker created')
                navigate('/search',{replace:true})
            }
            if(response.status === 400){
                alert('Was an error, verify if some field is empty or perhaps your email already exists')
            }
            if(response.status === 500 || response.status === 503 || response.status === 504){
                alert("There's an error with server")
            }
        }).catch(e=> console.log(e))
    }

    return (
      <div className="Insert">
         
         <Button
            variant='outlined'
            color='primary'
            size='large'
            style={{ marginBottom:'60px'}}
            onClick={exit}
          >exit</Button>

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker name'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerName}
            onChange={(e)=>{setWorkerName(e.target.value)}}
        />

        
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker email'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerEmail}
            onChange={(e)=>{setWorkerEmail(e.target.value)}}
        />

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker post'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerPost}
            onChange={(e)=>{setWorkerPost(e.target.value)}}
        />

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker address'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerAddress}
            onChange={(e)=>{setWorkerAddress(e.target.value)}}
        /> 
    
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker phone number'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerPhoneNumber}
            onChange={(e)=>{setWorkerPhoneNumber(e.target.value)}}
        /> 

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker age'
            style={{backgroundColor: '#035AA6', 
                    marginBottom:'10px', 
                    borderRadius:'6px'}}
            value={workerAge}
            onChange={(e)=>{setWorkerAge(e.target.value)}}
        /> 
      
        <Button
            variant='outlined'
            color='primary'
            size='large'
            onClick={send}
          >send</Button>

      </div>
    );
}


