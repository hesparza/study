<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/


Route::get('/', [
    'uses' => 'PostController@getIndex',
    'as' => 'blog.index'
]);

Route::get('post/{id}', [
    'uses' => 'PostController@getPost',
    'as' => 'blog.post'
]);

Route::get('post/{id}/like', [
    'uses' => 'PostController@getLikePost',
    'as' => 'blog.post.like'
]);

Route::get('about', function () {
    return view('other.about');
})->name('about');

Route::group(['prefix' => 'admin'], function() {
    Route::get('', [
        'uses' => 'PostController@getAdminIndex',
        'as' => 'admin.index'
    ]);

    //Posts
    Route::get('create', [
        'uses' => 'PostController@getAdminCreate',
        'as' => 'admin.create'
    ]);

    Route::post('create', [
        'uses' => 'PostController@postAdminCreate',
        'as' => 'admin.create'
    ]);

    Route::get('edit/{id}', [
        'uses' => 'PostController@getAdminEdit',
        'as' =>'admin.edit'
    ]);

    Route::post('edit', [
        'uses' => 'PostController@postAdminEdit',
        'as' => 'admin.update' /** <--- Note that as the edit route receives a parameter, we cannot call this admin.create **/
    ]);

    Route::get('delete', [
        'uses' => 'PostController@postAdminDelete',
        'as' => 'admin.delete'
    ]);

    //Tags
    Route::get('createTag', [
        'uses' => 'TagController@getAdminCreate',
        'as' => 'admin.create.tag'
    ]);

    Route::post('createTag', [
        'uses' => 'TagController@postAdminCreate',
        'as' => 'admin.create.tag'
    ]);

    Route::get('editTag/{id}', [
        'uses' => 'TagController@getAdminEdit',
        'as' =>'admin.edit.tag'
    ]);

    Route::post('editTag', [
        'uses' => 'TagController@postAdminEdit',
        'as' => 'admin.update.tag' /** <--- Note that as the edit route receives a parameter, we cannot call this admin.create **/
    ]);

    Route::get('deleteTag', [
        'uses' => 'TagController@postAdminDelete',
        'as' => 'admin.delete.tag'
    ]);
});
