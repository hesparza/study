App.Category = DS.Model.extend({
	title: DS.attr('string')
});

App.Category.reopenClass({
	FIXTURES: [
		{ id: 1, title: "Produce"},
		{ id: 2, title: "Baking"},
		{ id: 3, title: "Household Items"},
		{ id: 4, title: "Electronics"}
	]
});