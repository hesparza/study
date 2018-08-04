@extends('layouts.admin')

@section('content')
    @if(Session::has('info'))
    <div class="row">
        <div class="col-md-12">
            <p class="alert alert-info"><strong>{{ Session::get('info') }}</strong></p>
        </div>
    </div>
    @endif
    <h2>Posts</h2>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <a href="{{ route('admin.create') }}" class="btn btn-success">New Post</a>
        </div>
    </div>
    <br />
    @foreach($posts as $post)
    <div class="row">
        <div class="col-md-12">
            <p class="post-title">
                <strong>{{ $post->title }}</strong> <a href="{{ route('admin.edit', ['id' => $post->id]) }}">Edit</a> |
                                                    <a href="{{ route('admin.delete', ['id' => $post->id]) }}">Delete</a>
            </p>
        </div>
    </div>
    @endforeach
    <h2>Tags</h2>
    <hr>
    <div class="row">
        <div class="col-md-12">
            <a href="{{ route('admin.create.tag') }}" class="btn btn-warning">New Tag</a>
        </div>
    </div>
    <br />
    @foreach($tags as $tag)
        <div class="row">
            <div class="col-md-12">
                <p class="tag-title">
                    <strong>{{ $tag->name }}</strong> <a href="{{ route('admin.edit.tag', ['id' => $tag->id]) }}">Edit</a> |
                                                      <a href="{{ route('admin.delete.tag', ['id' => $tag->id]) }}">Delete</a>
                </p>
            </div>
        </div>
    @endforeach
@endsection