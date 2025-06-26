var PhoneNumber = function(){};

PhoneNumber.prototype.getPhoneNumber = function(success, failure, number, bypassAppChooser){
    cordova.exec(success, failure, "PhoneNumber", "getPhoneNumber", [number, bypassAppChooser]);
}

//Plug in to Cordova
cordova.addConstructor(function() {

    if (!window.Cordova) {
        window.Cordova = cordova;
    };

    if(!window.plugins) window.plugins = {};
    window.plugins.PhoneNumber = new PhoneNumber();
});
