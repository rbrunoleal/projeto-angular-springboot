const proxy = [
    {
      context: '/api',
      target: 'http://45.90.109.244:8089',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;