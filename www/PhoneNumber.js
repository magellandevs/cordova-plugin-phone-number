var PhoneNumber = function(){};

PhoneNumber.prototype.getPhoneNumber = function(success, failure){
    cordova.exec(success, failure, "PhoneNumber", "getPhoneNumber", []);
};

//Plug in to Cordova
cordova.addConstructor(function() {

    if (!window.Cordova) {
        window.Cordova = cordova;
    };

    if(!window.plugins) window.plugins = {};
    window.plugins.PhoneNumber = new PhoneNumber();
});
