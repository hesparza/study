<?php

namespace App\Http\Controllers;

use App\Tag;
use Illuminate\Http\Request;

class TagController extends Controller
{
    public function getAdminCreate() {
        $tags = Tag::all();
        return view('admin.createTag', ['tags' => $tags]);
    }

    public function getAdminEdit($id) {
        $tag = Tag::find($id);
        return view('admin.editTag', ['tag' => $tag]);
    }

    public function postAdminCreate(Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
           'name' => 'required|min:5',
           'description' => 'required|min:10'
        ]);
        $tag = new Tag([
            'name' => $request->input('name'),
            'description' => $request->input('description')
        ]);
        $tag->save();
        return redirect()->route('admin.index')->with('info', 'Tag created: '. $tag->name);
    }

    public function postAdminEdit(Request $request) {
        /*This next validator validates the request and if it fails, returns to the previous page with the $errors variable populated.. what about that*/
        $this->validate($request, [
            'name' => 'required|min:5',
            'description' => 'required|min:10'
        ]);
        $tag = Tag::find($request->input('id'));
        $tag->name = $request->input('name');
        $tag->description= $request->input('description');
        $tag->save();
        return redirect()->route('admin.index')->with('info', 'Tag edited: ' . $request->input('name'));
    }

    public function postAdminDelete(Request $request)
    {
        $tag = Tag::find($request->input('id'));
        $tag->posts()->detach();
        $tag->delete();
        return redirect()->route('admin.index')->with('info', 'Tag deleted: ' . $tag->name);
    }

}
