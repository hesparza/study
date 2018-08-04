    <?php
/**
 * Created by PhpStorm.
 * User: hesparza
 * Date: 7/11/17
 * Time: 12:17 AM
 */
namespace App;

use Illuminate\Database\Eloquent\Model;

class Post extends Model {
    protected $fillable = ['title', 'content'];

    //Establishing relation to other model, in this case Like
    public function likes() {
        return $this->hasMany('App\Like', 'post_id');
    }

    //Establish relation to Tag
    public function tags() {
        //withTimestamps is to assure that the timestamps are filled in the pivot table when the relation is created
        return $this->belongsToMany('App\Tag', 'post_tag', 'post_id', 'tag_id')->withTimestamps();
    }

    //Old code below
    public function getPosts($session) {
        if(!$session->has('posts')) {
            $this->createDummyData($session);
        }
        return $session->get('posts');
    }

    public function getPost($session, $id) {
        if(!$session->has('posts')){
            $this->createDummyData($session);
        }
        return $session->get('posts')[$id];
    }

    public function addPost($session, $title, $content) {
        if(!$session->has('posts')) {
            $this->createDummyData($session);
        }
        $posts = $session->get('posts');
        array_push($posts, ['title' => $title, 'content' => $content]);
        $session->put('posts', $posts);
    }

    public function editPost($session, $id, $title, $content) {
        $posts = $session->get('posts');
        $posts[$id] = ['title' => $title, 'content' => $content];
        $session->put('posts', $posts);
    }

    public function createDummyData($session) {
        $posts = [
            [
                'title' => 'Learning Laravel',
                'content' => 'This blog post will get you right on track with Laravel!'
            ],
            [
                'title' => 'Something else',
                'content' => 'This is some other content'
            ],
            [
                'title' => 'Cirque do soleil',
                'content' => 'The michael jackson show named'
            ]
        ];
        $session->put('posts', $posts);
    }
}