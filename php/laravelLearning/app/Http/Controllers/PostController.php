<?php

namespace App\Http\Controllers;

use App\Services\Post;
use Illuminate\Http\Request;
use Illuminate\Session\Store;

class PostController extends Controller
{
    public function getIndex(Store $session) {
        $post = new Post();
        $posts = $post->getPosts($session);
        return view('blog.index', ['posts' => $posts]);
    }

    public function getPost(Store $session, $id) {
        $post = new Post();
        $post = $post->getPost($session, $id);
        return view('blog.post', ['post' => $post]);
    }

    public function getAdminCreate() {
        return view('admin.create');
    }

    public function getAdminIndex(Store $session) {
        $post = new Post();
        $posts = $post->getPosts($session);
        return view('admin.index', ['posts' => $posts]);
    }

    public function getAdminEdit(Store $session, $id) {
        $post = new Post();
        $post = $post->getPost($session, $id);
        return view('admin.edit', ['post' => $post, 'postId' => $id]);
    }

    public function postAdminCreate(Store $session, Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
           'title' => 'required|min:5',
           'content' => 'required|min:10'
        ]);
        $post = new Post();
        $post->addPost($session, $request->input('title'), $request->input('content'));
        return redirect()->route('admin.index')->with('info', $request->input('title'));
    }

    public function postAdminEdit(Store $session, Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
            'title' => 'required|min:5',
            'content' => 'required|min:10'
        ]);
        $post = new Post();
        $post->editPost($session, $request->input('id'), $request->input('title'), $request->input('content'));
        return redirect()->route('admin.index')->with('info', $request->input('title'));
    }
}
