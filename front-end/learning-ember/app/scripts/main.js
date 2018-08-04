var App = Ember.Application.create({
  rootElement: $('#app')
});

App.ApplicationAdapter = DS.FixtureAdapter;

App.IndexRoute = Ember.Route.extend({
	model: function() {
		return this.store.find('category');
	}
});

App.CategoryRoute = Ember.Route.extend({
	model: function(params) {
		return this.store.find('category', params.id)
	}
});

App.Router.map(function(){
	this.resource('category', {path: ':id'})
});
