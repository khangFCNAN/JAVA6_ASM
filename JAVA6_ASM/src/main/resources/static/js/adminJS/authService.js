var authService = {
    loggedInAccount: null,
    
    setLoggedInAccount: function(account) {
        this.loggedInAccount = account;
    },
    
    getLoggedInAccount: function() {
        return this.loggedInAccount;
    }
};

export default authService;