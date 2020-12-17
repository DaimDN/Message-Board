import React, {Fragment, useState} from 'react'
import api from '../util/api';


const AddMessage = ()=> {
    var date = new Date();
var today = date.toLocaleDateString();


    const [formData, setFormData] = useState({
        email: '',
        message: '',
        key: today
      });

const { email, message, key } = formData;


  const onChange = e =>
    setFormData({ ...formData, [e.target.name]: e.target.value });

   
    
    const Handler = e => {
        e.preventDefault();

        var data = {email, message, key};
        
        async function postMessage() {
            try {
              const request = await api.post('/add', data);
              
            }
            
            catch (error) {          
                console.log(error);
            }
         }
         postMessage();

         setFormData({
             email: '',
             message :'',
             key: today
         })
            
      };
    

    return (
       
        <Fragment>
            <div className="container">
            
            <form className="form" onSubmit={Handler}>

            <div className="form-group">
          <input
            type="email"
            placeholder="name@example.com"
            name="email"
            value={email}
            onChange={onChange}
            className="form-control"
            required
          />
        </div>


        <div className="form-group">
          <textarea
            type="text"
            placeholder=""
            name="message"
            rows="4"
            value={message}
            onChange={onChange}           
            
            className="form-control"
            required
          />
        </div>
        <div className="mr-auto text-right">
        <button type="submit" className="btn btn-primary" >Post </button> 
        </div>
            </form>

            </div>
        </Fragment>
    )
}


export default AddMessage;