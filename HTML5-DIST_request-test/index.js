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

    doc.location.href='index_data.html'
})
