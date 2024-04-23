// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import History from './pages/History';
import ContactUs from './pages/ContactUs';
import Calculation from './pages/Calculation';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/history">
          <History />
        </Route>
        <Route path="/contact">
          <ContactUs />
        </Route>
        <Route path="/calculation">
          <Calculation />
        </Route>
        <Route path="/">
          <Calculation />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
