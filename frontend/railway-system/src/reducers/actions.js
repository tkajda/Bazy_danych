export const LOGIN = 'LOGGED_IN';
export const loggedIn = (userAuthData) =>(
    {
        type:'LOGGED_IN',
        payload:{ userAuthData }
    }
);

export const LOGOUT='LOGGED_OUT';
export const loggedOut = () => (
    {
        type:'LOGGED_OUT',
        payload:{}
    }
)

export const SET_ROUTE='SET_ROUTE';
export const setRoute = (route) => (
    {
        type:'SET_ROUTE',
        payload:{route}
    }
)

export const UNSET_ROUTE='UNSET_ROUTE';
export const unsetRoute = () => (
    {
        type:'UNSET_ROUTE',
        payload:{}
    }
)