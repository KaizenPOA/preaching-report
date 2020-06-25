create table publishers (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR not null,
    active boolean default true,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    group_id uuid,
    FOREIGN KEY (group_id) REFERENCES groups (id)
)