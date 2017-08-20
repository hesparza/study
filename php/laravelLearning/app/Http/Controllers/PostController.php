<?php

namespace App\Http\Controllers;

use App\Post;
use App\Like;
use App\Tag;
use Illuminate\Http\Request;
use Illuminate\Session\Store;

class PostController extends Controller
{
    public function getIndex() {
        $posts = Post::orderBy('title', 'asc')->get();
        return view('blog.index', ['posts' => $posts]);
    }

    public function getPost($id) {
        //Here, the "whit" is to eagerly load the post along with its likes
        $post = Post::where('id', $id)->with('likes')->first();
        return view('blog.post', ['post' => $post]);
    }

    public function getLikePost($id) {
        $post = Post::find($id);
        $like = new Like();
        $post->likes()->save($like);
        return redirect()->back();
    }
    public function getAdminCreate() {
        $tags = Tag::all();
        return view('admin.create', ['tags' => $tags]);
    }

    public function getAdminIndex() {
        $posts = Post::orderBy('title', 'asc')->get();
        $tags = Tag::orderBy('name', 'asc')->get();
        return view('admin.index', ['posts' => $posts, 'tags' => $tags]);
    }

    public function getAdminEdit($id) {
        $post = Post::find($id);
        $tags = Tag::all();
        return view('admin.edit', ['post' => $post, 'tags' => $tags]);
    }

    public function postAdminCreate(Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
           'title' => 'required|min:5',
           'content' => 'required|min:10'
        ]);
        $post = new Post([
            'title' => $request->input('title'),
            'content' => $request->input('content')
        ]);
        $post->save();
        $post->tags()->attach($request->input('tags') === null ? [] : $request->input('tags'));
        return redirect()->route('admin.index')->with('info', 'Post created: '. $post->title);
    }

    public function postAdminEdit(Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
            'title' => 'required|min:5',
            'content' => 'required|min:10'
        ]);
        $post = Post::find($request->input('id'));
        $post->title = $request->input('title');
        $post->content = $request->input('content');
        $post->save();
        $post->tags()->sync($request->input('tags') === null ? [] : $request->input('tags'));
        return redirect()->route('admin.index')->with('info', 'Post edited: ' . $request->input('title'));
    }

    public function postAdminDelete(Request $request)
    {
        $post = Post::find($request->input('id'));
        $post->likes()->delete();
        $post->tags()->detach();
        $post->delete();
        return redirect()->route('admin.index')->with('info', 'Post deleted: ' . $post->title);
    }

}
