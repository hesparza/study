<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Tag extends Model
{
    protected $fillable = ['name', 'description'];

    //Establish a relation to Post
    public function posts() {
        //withTimestamps is to assure that the timestamps are filled in the pivot table when the relation is created
        return $this->belongsToMany('App\Post', 'post_tag', 'tag_id', 'post_id')->withTimestamps();
    }
}
