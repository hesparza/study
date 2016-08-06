(function() {
	"use strict";

	$("#navbarButtons button").on("click", function(){
		var location = this.id;
		document.location = location;
	});
})();