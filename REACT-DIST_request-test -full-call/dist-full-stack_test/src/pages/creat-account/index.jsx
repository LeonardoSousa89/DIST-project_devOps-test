import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { signUp } from '../../services'
import { auth, db } from '../../services/db'

export default function Account() {

    const [username, setUsername]=useState([])
    const [email, setEmail]=useState([])
    const [password, setPassword]=useState([])

    const navigate=useNavigate()

    useEffect(()=>{},[])

    function navigation(){
        navigate('/insert',{replace:true})
    }
    
    function send(){
        signUp(username, auth, email, password, navigation)
    }


    return (
        <div className="Account">

        <TextField
            variant='outlined'
            color='primary' 
            placeholder='username'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
            value={username}
            onChange={(e)=>{setUsername(e.target.value)}}
        />

        
        <TextField
            variant='outlined'
            color='primary' 
            placeholder='email'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
            value={email}
            onChange={(e)=>{setEmail(e.target.value)}}
        />

        <TextField
            variant='outlined'
            color='primary' 
            type='password'
            placeholder='password'
            style={{backgroundColor: '#035AA6', marginBottom:'10px', borderRadius:'6px'}}
            value={password}
            onChange={(e)=>{setPassword(e.target.value)}}
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


