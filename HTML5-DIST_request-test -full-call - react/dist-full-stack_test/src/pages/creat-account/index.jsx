import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Account() {

    const navigate=useNavigate()

    useEffect(()=>{},[])
    
    async function send(){
        navigate('/insert',{replace:true})
    }


    return (
        <div className="Account">

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='username'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        />

        
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='email'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
        />
        
        <Button
            variant='outlined'
            color='primary'
            size='large'
            onClick={send}
        >send
        </Button>

    </div>
  );
}


