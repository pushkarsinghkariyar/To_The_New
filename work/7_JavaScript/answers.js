//QUESION1

function simple_int(){
console.clear();
var principle = prompt("Enter principle");// Number(readline());
var interest = prompt("Enter interest");// Number(readline());
var years = prompt("Enter year");//Number(readline());

var simple_interest = principle * interest * years;
simple_interest = simple_interest / 100;
console.log("Your simple interest is " , simple_interest);
}

//QUESION2

function pallindrome() {
	console.clear();
var s = prompt("Enter a string");

var x = s.length;
var txt = "";
for(var i = x -1  ; i >= 0 ; --i) {
	// console.log("This is \n" , x[i])
	txt += s[i];
}
if(txt===s) {
	alert("Pallindrome");
}
else{
	alert("Not Pallindrome");
}
}

//QUESION3

function circle() {
	console.clear();
	var pii = 3.1415;
	var radii = prompt("Enter radius");
	var area = pii * radii * radii;
	console.log("area is " , area);
}

//QUESION4

function cpyObject() {
	console.clear();
	var person1 = {
		firstName : "Pushkar",
		lastName : 'Singh',
		age : 23

	};
	var person2 = Object.assign({}, person1);
	console.log(person2.firstName , " " , person2.lastName , " " , person2.age);

}

//QUESION5

function ques5(){
	console.clear();
	var list = [
    {Name: 'Pushkar singh', age: 23, salary: 30 , DOB :'18/1/1995'},
    {Name: 'Archit Chauhan', age: 27, salary: 2 , DOB :'9/2/1995'},
    {Name: 'Ankit Kapoor', age: 31, salary: 1 , DOB :'12/10/1998'},
    {Name: 'Payal Nigam,', age: 23, salary: 4 , DOB :'17/8/1994'},
    {Name: 'Shreyansh Sahu', age: 22, salary: 5 , DOB :'13/1/1995'},
    {Name: 'Swapnil Khanna', age: 21, salary: 4 , DOB :'13/1/1996'},
    {Name: 'Sooraj Awasthi', age: 29, salary: 33 , DOB :'13/1/1995'},
    {Name: 'Pushkar Katiyar', age: 42, salary: 197 , DOB :'15/7/1983'},
   
	];

	console.log("LIST CREATED\n---------------------------\n");
	var x = list.length;
	for(var i = 0 ; i < x ; i++ ){
		if(list[i].salary > 5){
			console.log(list[i].Name);
		}
	}
	console.log("PEOPLE WERE FILTERED WITH ABOVE 5 K salary");
	// ?console.log("\n---------------------------\n");
	console.log("Group 20 - 25");
	for(var i = 0 ; i < x ; i++ ){
		if(list[i].age >= 20 && list[i].age <= 25){
			console.log(list[i].Name);
		}
	}
	console.log("\nGroup 25  - 30");
	for(var i = 0 ; i < x ; i++ ){
		if(list[i].age >= 25 && list[i].age <= 30){
			console.log(list[i].Name);
		}
	}
	console.log("\nGroup 30 + ");
	for(var i = 0 ; i < x ; i++ ){
		if(list[i].age >= 30){
			console.log(list[i].Name);
		}
	}
	console.log("\nfetch employees with salary less than 10000 and age greater than 20. Then give them an increment 5 times their salary.")
	for(var i = 0 ; i < x; i++){
		if(list[i].salary < 10000 && list[i].age > 20) {
			list[i].salary += 5 * list[i].salary;
		}
	}
}
