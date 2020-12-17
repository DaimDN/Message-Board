import React, {Fragment, useState, useEffect} from 'react'
import Display from './components/display';
import Error from './components/error';
import api from './util/api';

 function App() {
    
const [display, setDisplay ] = useState(false);  

const [data, setData] = useState(undefined);

useEffect(() => {

    (async function getLanding() {
        try {
          const response = await api.get('/');
        
          var HttpStatusCode = response.status;
          
          if(HttpStatusCode === 200){
            var dataset = response.data;
              setData(dataset);
          }
        }
        
        catch (error) {          
            console.log(error);
            setData(undefined);
        }
      })();
   

      if(data === undefined){
        setDisplay(false);
      }
      else{
        setDisplay(true);

      }
});


   
if(display === false){
    return (
       <Fragment>
           <Error/>
       </Fragment>
    )
}
else{
    return (
        <Fragment>
            <Display message={data}/>
        </Fragment>
    )
}}


export default  App;