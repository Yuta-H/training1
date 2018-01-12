//body要素から ng-app="App"
angular.module('App', ['LocationBar'])
.controller('MainController',['$scope','$filter', function($scope, $filter){

	//空のリストを作成
	$scope.todos = [];

	//要件の初期値はnullなので空にする
	$scope.newTitle = '';

	//新しく要件を追加するためのメソッドを作成
	$scope.addTodo = function (){
		$scope.todos.push({
			title:$scope.newTitle,
			done:false
		});
		//ng-modelにより送られてきた値をnullにして返す
		$scope.newTitle='';
	};
	//現在のフィルターの状態から、完了の時は打線を引く　未了の時は打線を外すよう指定して返す
	$scope.filter ={
			done:{done:true},
			remaining:{done: false},
	};
	//現在のフィルターの状態（初期値はnull）
	$scope.currentFilter = null;

	//フィルターの条件を変更して現在の状態を変更する
	$scope.changeFilter = function(filter){
		$scope.currentFilter = filter;
	};

	var where = $filter('filter');
	//$watchを使ってリストが変更された時に正しい件数を表示させるようにする
	$scope.$watch('todos',function(todos){
		var length = todos.length;

		//htmlに記述した、{{}}内の値を受け取る
		$scope.allCount = length;
		$scope.doneCount = where(todos, $scope.filter.done).length;
		$scope.remainingCount = length - $scope.doneCount;
	},true);

	var originalTitle;	//編集前の要件
	$scope.editing = null;//編集モードのTodoモデルを表すモデル

	//ダブルクリックした時の処理
	$scope.editTodo = function(todo){
		originalTitle = todo.title; //要件だけが映し出される
		$scope.editing =todo;
	};
	//編集を確定し、編集モードを終わらせる
	$scope.doneEdit = function(todoForm){
		if(todoForm.$invalid){
			$scope.editing = originalTitle;
		}
		$scope.editing = originalTitle = null;
	};

	//全て完了/未了ボタン
	$scope.checkAll = function(){
		var state = !!$scope.remainingCount;  //未了にするか完了にするかを判定する

		angular.forEach($scope.todos, function(todo){
			todo.done = state;
		});
	};

	//完了したアイテムを全て削除ボタン　
	$scope.removeDoneTodo = function () {
		//where でどこからかを指定
	    $scope.todos = where($scope.todos, $scope.filter.remaining);
	  };
	  //チェックをつけたTodoを削除
	$scope.removeTodo =  function(currentTodo){
		$scope.todos = where($scope.todos, function(todo){
			return currentTodo !== todo;
		});
	};
}])
//htmlのmySelectディレクトリから処理に応じて結果を返す
.directiv('mySelect',[function(){
	return function(scope, $el, attrs){
		//現在の$scope オブジェクト
		//$el jqLite オブジェクト(jQuery ライクオブジェクト)
		// attrs - DOM 属性のハッシュ(属性名は正規化されている)
		scope.$watch(attrs.mySelect,function(val){
			if(val){
				$el[0].select();
			}
		});
	};
}]);