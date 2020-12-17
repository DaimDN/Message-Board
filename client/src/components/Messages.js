import React, {Fragment, useEffect, useState} from 'react'
import api from '../util/api';

function Messages() {
    const [messages, setMessage] = useState(undefined);

    useEffect(() => {

        async function getMessage() {
            try {
              const response = await api.get('/api/v1');
            
              var HttpStatusCode = response.status;
              
              if(HttpStatusCode === 200){
                var dataset = response.data;
                  setMessage({Messages: dataset});
              }
            }
            
            catch (error) {          
                console.log(error);
                setMessage(undefined);
            }
                }
            getMessage();
    });



        
    const Handler = e => {
        e.preventDefault();

        async function LoadDummyContent() {
            try {
              const dummy = await api.get('/dummy');
              alert("Dummy Contents Updated")
              
            }
            
            catch (error) {          
                console.log(error);
            }
         }

         LoadDummyContent();


    }
            

    if(messages === undefined){

        return (
            <Fragment>
                <div className="container">
                <div className="text-center">
                    <h2>Error Occured</h2>
                </div>
               
      
                </div>
            </Fragment>

        )

    }
    else{


            if(messages.Messages.length ===0){

                return(

                <Fragment>
                     <div className="container">
                        <div className="text-center">
                            <h2>Messages</h2>
                            <p className="lead">No Messages Available</p>

                            <form onSubmit={Handler}>
                            <button className="btn btn-primary btn-lg">Load Dummy Data</button>
                            </form>
                            
                        </div>
                       
              
                        </div>
                </Fragment>
                )

            }
            else{

                return (
                    <Fragment>
                        <div className="container">
                        <div className="text-center">
                            <h2>Messages</h2>
                        </div>
                        <br/>
                        {messages.Messages.map((item)=>{
                            return <div style={{marginBottom: '12px'}} class="card">
                                    <div className="container">
                                    
                                    <div class="card-body">
                                    <h4 style={{marginRight: '20px'}}>  {item.email}</h4>
                                    <br/>
                                    <p className="lead">{item.message} </p>
                                    </div>
                                    </div>
                                    </div>
                        })}
                       
              
                        </div>
                    </Fragment>
                  )
            }


       

    }
          
    
       

    

   
}



export default Messages;