let URL='http://localhost:8765/User/dist/worker/administration'

let doc=document

let form={
    send: doc.getElementById('send'),
    workerName: doc.getElementById('workername'),
    workerEmail: doc.getElementById('workeremail'),
    workerPost: doc.getElementById('workerpost'),
    workerAddress: doc.getElementById('workeraddress'),
    workerPhoneNumber: doc.getElementById('workerphonenumber'),
    workerAge: doc.getElementById('workerage'),
    admin: doc.getElementById('user_id')
}

form.send.addEventListener('click',(e)=>{
    e.preventDefault()

    let data={  workerName: form.workerName.value,
        workerEmail: form.workerEmail.value,
        workerPost: form.workerPost.value,
        workerAddress: form.workerAddress.value,
        workerPhoneNumber: form.workerPhoneNumber.value,
        workerAge: form.workerAge.value,
        admin: { userId: form.admin.value }
    }

    let config= { 
        method: 'POST', 
        body: JSON.stringify(data),
        headers:{
            'Content-type':'application/json'
        }
    }

    fetch(URL, config)
        .then(response=>{
            if(response.status === 201){
                response.json()
                alert("worker created")
                doc.location.href='index_search.html'
            }
            if(response.status === 400){
                alert("Was an error, verify if some field is empty or perhaps already exists")
            }
            if(response.status === 504 || 
                response.status === 503 || 
                response.status === 500 ) {

                alert("There's an error with server") 
            }
        })
        .catch(e=>console.log(e))
})

