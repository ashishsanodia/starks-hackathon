var app = angular.module('app', ["ngRoute"]);

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'partials/login.html',
            controller: 'LoginController',
            controllerAs: 'vm'
        }).when('/offer', {
            templateUrl: 'partials/offer.html',
            controller: 'OfferController',
            controllerAs: 'vm'
        }).otherwise({
            templateUrl: 'partials/home.html',
            controller: 'FrontController',
            controllerAs: 'vm'
        });
    }
]);

(function () {
    'use strict';
    angular
        .module('app')
        .controller('LoginController', LoginController);
    LoginController.$inject = ['$rootScope', '$location'];
    function LoginController($rootScope, $location) {
        var vm = this;
        vm.login = login;
        function login() {
            $rootScope.isLoggedIn = true;
            $rootScope.email=vm.email;
            $location.path('offer');
        }
    }
})();

(function () {
    'use strict';
    angular
        .module('app')
        .controller('FrontController', FrontController);
    FrontController.$inject = ['$rootScope'];
    function FrontController($rootScope) {
        $rootScope.isLoggedIn = false;
    }
})();

(function () {
    'use strict';
    angular
        .module('app')
        .controller('OfferController', OfferController);
    OfferController.$inject = ['$rootScope', '$http'];
    function OfferController($http) {
        $http.get('http://localhost:8080/version')
            .success(function (res) {
            })
            .error(function (res) {
            });
    }
})();