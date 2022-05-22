import {LOGIN, LOGOUT, SET_ROUTE, UNSET_ROUTE} from './actions'
export const authReducer = (state={isLoggedIn:false}, action) => {
    console.log(state)
    console.log(action)
    const {type, payload}=action;
    switch(type){
        case LOGIN:{
            
            return {isLoggedIn:true, authData:payload}
        }
        case LOGOUT:{
            return {isLoggedIn:false}
        }
        default:{
            return state;
        }
    }
}

export const chosenRoute= (state={}, action) => {
    const {type, payload}=action;
    switch(type){
        case SET_ROUTE:{
            
            return payload
        }
        case UNSET_ROUTE:{
            return {}
        }
        default:{
            return state;
        }
    }
}