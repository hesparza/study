@extends('layouts.admin')

@section('content')
    @include('partials.errors')
    <div class="row">
        <div class="col-md-12">
            <h2>Edit Tag</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <form action="{{ route('admin.update.tag') }}" method="post">
                <div class="form-group">
                    <label for="name">name</label>
                    <input type="text" class="form-control" id="name" name="name" value="{{ $tag->name }}">
                </div>
                <div class="form-group">
                    <label for="description">description</label>
                    <input type="text" class="form-control" id="description" name="description" value="{{ $tag->description }}">
                </div>
                {{csrf_field()}}
                <input type="hidden" name="id" value="{{ $tag->id }}">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
@endsection