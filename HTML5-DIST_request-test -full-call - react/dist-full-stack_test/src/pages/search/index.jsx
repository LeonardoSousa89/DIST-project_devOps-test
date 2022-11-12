import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Search() {
    
    const navigate=useNavigate()

    useEffect(()=>{},[])
      
    async function back(){
        navigate('/insert',{replace:true})
    }



    return (
        <div className="Search">
            
            <Button
            variant='outlined'
            color='primary'
            size='large'
            onClick={back}
            >back</Button>

        </div>
    );
}


