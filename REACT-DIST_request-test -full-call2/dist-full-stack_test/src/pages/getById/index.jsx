import '../../App.css';

import { Button, TextField } from '@material-ui/core'
import Grid from '@material-ui/core/Grid'
import SaveIcon from '@material-ui/icons/Save';

import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function GetById() {

    const [data, setData]=useState([])

    const navigate=useNavigate()

    useEffect(()=>{

        load()

    },[])
      
    async function back(){
        navigate('/search',{replace:true})
    }

    function load(){

        let URL=localStorage.getItem("URL")
        let URLJson=JSON.parse(URL)
       
        let config={
            method: 'GET'
        }

        fetch(URLJson, config).then(response=>{

            if(response.status === 200){

                response.json().then(response=>{
                    setData(response.content)
                })
            }
            if(response.status === 404){
                alert('Resource not found')
            }
            if(response.status === 500 || response.status === 503 || response.status === 504){
                alert("There's an error with server")
            }
        }).catch(e=> console.log(e))
    }

    return (
        <div className="getById">

            <Button
                variant='outlined'
                color='primary'
                size='large'
                style={{margin: '10px 10px'}}
                onClick={back}
                >back
            </Button>

            <div className='containerData'>                    
                    {
                        data.map(e=>{
                            return(
                                <div key={e.workerId}>

                                    <span className='card'>
                                        <strong>{'ID: ' + e.workerId}</strong>
                                        <strong>{'NAME:  ' + e.workerName} </strong>
                                        <strong>{'EMAIL:  ' + e.workerEmail}<hr/></strong>
                                        <strong>{'POST:  ' + e.workerPost}</strong>
                                        <strong>{'ADDRESS:  ' + e.workerAddress}</strong>
                                        <strong>{'CONTACT:  ' + e.workerPhoneNumber}</strong>
                                        <strong>{'AGE:  ' + e.workerAge}</strong>
                                    </span>
                                   
                                </div>
                            )
                        })
                    }
            </div>

        </div>
    );
}


