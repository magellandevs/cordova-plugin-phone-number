window.getPhoneNumber = function(success, error) {
    cordova.exec(success, error, "PhoneNumber", "getPhoneNumber", []);
};