import React, {Component} from 'react';

class HeaderComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    render() {
        return (
            <div style={{marginBottom: 50}}>
                <header>
                    <nav className="navbar bavbar-expand-md navbar-dark bg-dark">
                        <div>Class Management</div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;