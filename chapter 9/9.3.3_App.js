import { useEffect, useState } from 'react';

function App() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    fetch('/api/tasks')
      .then(res => res.json())
      .then(data => setTasks(data));
  }, []);

  return (
    <div>
      <h1>Tasks</h1>
      <ul>
        {tasks.map(t => <li key={t.id}>{t.description}</li>)}
      </ul>
    </div>
  );
}

export default App;