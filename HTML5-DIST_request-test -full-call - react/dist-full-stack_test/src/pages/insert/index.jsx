import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Insert() {

    const navigate=useNavigate()

    useEffect(()=>{},[])
      
    async function send(){
        navigate('/search',{replace:true})
    }

    function RequestInsert(){
        let URL='http://localhost:8765/User/dist/worker/administration'
    }

    return (
      <div className="Insert">

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker name'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        />

        
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker email'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        />

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker post'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        />

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker address'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        /> 
        
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker phone number'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        /> 

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='worker age'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
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


