import React, { Fragment } from 'react'
import {useState} from 'react';
import api from '../util/api';
import Messages from './Messages';
import AddMessage from './AddMessage';

 
const Display = props =>{

    

    const [dataset, setDataset] = useState(props);
    return (
        <Fragment>

       
        <div className="container">
        <div className="text-center">
          <h2>{dataset.message.welcome}</h2>
        </div>
        </div>
        <div style={{marginTop: '22px'}}>
            <AddMessage/>
        </div>
        <div style={{marginTop: '22px'}}>
            <Messages/>
        </div>
        
        </Fragment>
    )
}

export default Display;