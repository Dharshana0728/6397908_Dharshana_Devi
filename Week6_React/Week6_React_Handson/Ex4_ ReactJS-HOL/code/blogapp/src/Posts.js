import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null,
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        // Map JSON objects to Post instances (optional)
        const posts = data.map(
          (p) => new Post(p.userId, p.id, p.title, p.body)
        );
        this.setState({ posts });
      })
      .catch((error) => {
        this.setState({ error });
      });
  };

  // Lifecycle hook to fetch posts after component mounts
  componentDidMount() {
    this.loadPosts();
  }

  // Lifecycle hook to catch errors from children
  componentDidCatch(error, info) {
    alert('Something went wrong: ' + error.message);
  }

  render() {
    const { posts, error } = this.state;

    if (error) {
      return <div>Error: {error.message}</div>;
    }

    return (
      <div>
        <h1>Blog Posts</h1>
        {posts.map((post) => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
