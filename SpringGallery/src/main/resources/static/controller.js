
app.controller('galleryCtrl', function($scope,$http) {
    $scope.pictures = [];
    $http.get("/infos").then(function (response) {
        $scope.pictures = response.data;
        console.log($scope.pictures);
    })

    $scope.deleteImage = function (name) {
        $http.delete('/pictures/'+name).then(function (response) {
            console.log('delete succesful');

        })

    }
});

