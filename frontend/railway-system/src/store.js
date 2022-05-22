import {createStore, combineReducers} from 'redux'
import {authReducer,chosenRoute} from './reducers/authReducer'
const reducers={authReducer,chosenRoute}
const rootReducer=combineReducers(reducers);

export const configureStore = () => createStore(rootReducer);