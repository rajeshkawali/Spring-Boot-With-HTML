var app = angular.module('app', []);

app.controller('postcontroller', function($scope, $http, $location) {
	
	$scope.editMode=false;
    $scope.editModeFun=function(){
        $scope.editMode=true;
    }
	
	$scope.removeStudent = function(id){
		var url = $location.absUrl() + "student/"+id;
		alert(url);
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		$http.delete(url, config).then(function (response) {
			$scope.response = response.data
		}, function (response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	
	$scope.getStudentById = function(id){
		$scope.editMode=true;
		var url = $location.absUrl() + "student/"+id;
		alert(url);
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		$http.get(url, config).then(function (response) {
			$scope.data = response.data
		}, function (response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	
	$scope.getAllstudent = function(){
		var url = $location.absUrl() + "allstudent";
		alert(url);
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		$http.get(url, config).then(function (response) {
			$scope.response = response.data
		}, function (response) {
			$scope.getResultMessage = "Fail!";
		});
	}
	
	$scope.submitForm = function(){
		
		if($scope.editMode==false){
			// Save student
			var url = $location.absUrl() + "addstudent";
			alert(url);
			var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
			var data = {
	            firstname: $scope.firstname,
	            lastname: $scope.lastname,
	            percentage:$scope.percentage
	        };
			$http.post(url, data, config).then(function (response) {
				$scope.postResultMessage = "Sucessful!";
			}, function (response) {
				$scope.postResultMessage = "Fail!";
			});
			$scope.firstname = "";
			$scope.lastname = "";
			$scope.percentage ="";
			
		}else{
			// updating student
			alert($scope.data.id)
			var url = $location.absUrl() + "updatestudent";
			alert(url);
			var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
			var data = {
	            firstname: $scope.firstname,
	            lastname: $scope.lastname,
	            percentage:$scope.percentage,
	            id:$scope.data.id
	        };
			$http.put(url, data, config).then(function (response) {
				$scope.postResultMessage = "Sucessful!";
			}, function (response) {
				$scope.postResultMessage = "Fail!";
			});
		}
	}
});

app.controller('getcontroller', function($scope, $http, $location) {
	
	$scope.removeStudent = function(id){
		var url = $location.absUrl() + "student/"+id;
		alert(url);
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		$http.delete(url, config).then(function (response) {
			$scope.response = response.data
		}, function (response) {
			$scope.getResultMessage = "Fail!";
		});
	}

});
