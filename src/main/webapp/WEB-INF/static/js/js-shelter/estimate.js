		var countWall = 1;
		var countDoor = 1;
		var countWind = 1;
		

		function add_wall() {
			//创建div节点
			countWall++;
			var div = document.createElement('div');
			div.setAttribute('class', 'form-group');
			div.setAttribute('id', 'wall' + countWall);
			//创建label节点
			var label = document.createElement("label");
			label.setAttribute('class', 'control-label');
			//创建文本节点
			var node = document.createTextNode("墙面" + countWall);
			
			//将文本节点添加到label节点里
			label.appendChild(node);
			var input = document.createElement('input');
			input.setAttribute('type', 'number');
			input.setAttribute('class', 'form-control');
			if(countWall<10){
			input.setAttribute('style', 'margin-left:14px');}
			else{
				input.setAttribute('style', 'margin-left:7px');
			}
			var span =document.createElement('span');
			span.setAttribute('style','margin-left:3px');
			var node=document.createTextNode("平方厘米");   
			span.appendChild(node);  
			div.appendChild(label);
			div.appendChild(input);
			div.appendChild(span);
			var element = document.getElementById("add_wall");
			element.appendChild(div);

		}

		function remove_wall() {
			if (countWall > 1) {
			var element = document.getElementById("add_wall");
			var div = document.getElementById("wall" + countWall);
			if(countWall>1){
				countWall--;}			
			element.removeChild(div);
			}
		}
		
		function add_door() {
			countDoor++;
			var div = document.createElement('div');
			div.setAttribute('class', 'form-group');
			div.setAttribute('id', 'door' + countDoor);

			var input1 = document.createElement('input');
			input1.setAttribute('type', 'number');
			input1.setAttribute('class', 'form-control');
			input1.setAttribute('placeholder', '宽');
			input1.setAttribute('id', 'door_w' + countDoor);
			var span1 = document.createElement('span');
			span1.setAttribute('style', 'margin-left:5px')
			var node1 = document.createTextNode("平方厘米");

			var input2 = document.createElement('input');
			input2.setAttribute('type', 'number');
			input2.setAttribute('class', 'form-control');
			input2.setAttribute('placeholder', '高');
			input2.setAttribute('style', 'margin-left:23px');
			input2.setAttribute('id', 'door_h' + countDoor);
			var span2 = document.createElement('span');
			span2.setAttribute('style', 'margin-left:5px')
			var node2 = document.createTextNode("平方厘米");

			span1.appendChild(node1);
			span2.appendChild(node2);
			div.appendChild(input1);
			div.appendChild(span1);
			div.appendChild(input2);
			div.appendChild(span2);

			var element = document.getElementById("add_door");
			element.appendChild(div);
		}
		
		function remove_door() {
			if(countDoor > 1) {
				var element = document.getElementById("add_door");
				var div = document.getElementById("door" + countDoor);
				if(countDoor > 1) {
					countDoor--;
				}
				element.removeChild(div);
			}
		}
		
		function add_wind() {
			countWind++;
			var div = document.createElement('div');
			div.setAttribute('class', 'form-group');
			div.setAttribute('id', 'wind' + countWind);

			var input1 = document.createElement('input');
			input1.setAttribute('type', 'number');
			input1.setAttribute('class', 'form-control');
			input1.setAttribute('placeholder', '宽');
			input1.setAttribute('id', 'wind_w' + countWind);
			var span1 = document.createElement('span');
			span1.setAttribute('style', 'margin-left:5px')
			var node1 = document.createTextNode("平方厘米");

			var input2 = document.createElement('input');
			input2.setAttribute('type', 'number');
			input2.setAttribute('class', 'form-control');
			input2.setAttribute('placeholder', '高');
			input2.setAttribute('style', 'margin-left:23px');
			input2.setAttribute('id', 'wind_h' + countWind);
			var span2 = document.createElement('span');
			span2.setAttribute('style', 'margin-left:5px')
			var node2 = document.createTextNode("平方厘米");

			span1.appendChild(node1);
			span2.appendChild(node2);
			div.appendChild(input1);
			div.appendChild(span1);
			div.appendChild(input2);
			div.appendChild(span2);

			var element = document.getElementById("add_wind");
			element.appendChild(div);
		}
		
		function remove_wind() {
			if(countWind > 1) {
				var element = document.getElementById("add_wind");
				var div = document.getElementById("wind" + countWind);
				if(countWind > 1) {
					countWind--;
				}
				element.removeChild(div);
			}
		}
		
		function showSubject(id) {
			var subject = $("#"+id).attr('value');
			document.getElementById("subject").value=subject;
		}
		
		
