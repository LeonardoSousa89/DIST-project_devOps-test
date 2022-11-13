import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function GetById() {
    const navigate=useNavigate()

    useEffect(()=>{},[])
      
    async function back(){
        navigate('/search',{replace:true})
    }

    function RequetLoad(){
        // let URL=`http://localhost:8765/User/dist/worker/${id}/administration?page=${page}`
    }

    return (
        <div className="getById">

            <Button
                variant='outlined'
                color='primary'
                size='large'
                onClick={back}
                >back
            </Button>

        </div>
    );
}


