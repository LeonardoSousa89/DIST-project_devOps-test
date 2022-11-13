import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Search() {
    
    // const [userId, setUserId]=useState([])
    const [page, setPage]=useState([])
    
    const navigate=useNavigate()

    useEffect(()=>{},[])
      
    function back(){
        navigate('/insert',{replace:true})
    }

    function get(){

        let userId=localStorage.getItem('ID')
        let userIdJson=JSON.parse(userId)
        let URL=`http://localhost:8765/User/dist/worker/${userIdJson}/administration?page=${page}`
        
        localStorage.setItem("URL", JSON.stringify(URL))
        
        navigate('/get-by-id',{replace:true})
    }

    return (
        <div className="Search">
            
            <Button
                variant='outlined'
                color='primary'
                size='large'
                style={{margin: '10px 10px'}}
                onClick={back}
                >back</Button>

            <div className="container">

                <TextField
                    variant='outlined'
                    type={'number'}
                    color='primary' 
                    placeholder='page'
                    style={{backgroundColor: '#035AA6', 
                            marginRight:'10px', 
                            borderRadius:'6px'}}
                    value={page}
                    onChange={(e)=>{setPage(e.target.value)}}
                />

                <Button
                    variant='outlined'
                    color='primary'
                    size='large'
                    style={{height: '58px'}}
                    onClick={get}
                    >get</Button>

            </div>

        </div>
    );
}


